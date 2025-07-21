(ns boilerplate-clojure.server
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.test :as test]))

(defn sum [a b]
  (+ a b))

(defn response [status body & {:as headers}]
  {:status status :body body :headers headers})

(def echo
  {:name :echo
   :enter
   (fn [context]
     (let [request (:request context)
           response (response 200 "Hello from Pedestal!")]
       (assoc context :response response)))})

(def routes
  (route/expand-routes
   #{["/" :get echo :route-name :list-query-form-root]}))

; ================================
; CONFIG
; ================================

(def service-map
  {::http/routes routes
   ::http/type :jetty
   ::http/port 8080})

(defn start []
  (http/start (http/create-server service-map)))

;; For interactive development
(defonce server (atom nil))

(defn start-dev []
  (reset! server
          (http/start (http/create-server
                       (assoc service-map
                              ::http/join? false)))))

(defn stop-dev []
  (http/stop @server))

(defn restart []
  (stop-dev)
  (start-dev))

(defn test-request [verb url]
  (io.pedestal.test/response-for (::http/service-fn @server) verb url))

(defn -main [& _args]
  (println (sum 1 2))
  ;; https://pedestal.io/pedestal/0.6/guides/your-first-api.html
  (start))


; TODO: https://pedestal.io/pedestal/0.6/guides/pedestal-with-component.html