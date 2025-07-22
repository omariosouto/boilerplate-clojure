(ns boilerplate-clojure.components
  (:require [boilerplate-clojure.config :as config]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.test :as test]
            [clojure.data.json :as json]))

(def version-interceptor
  {:name :version
   :enter
   (fn [context]
     (let [response {:status 200 
                     :body (json/write-str {:version (config/version {})})
                     :headers {"Content-Type" "application/json"}}]
       (assoc context :response response)))})

(def routes
  (route/expand-routes
   #{["/api/version" :get version-interceptor :route-name :version]}))

(def service-map
  {::http/routes routes
   ::http/type :jetty
   ::http/port 8080})

(defn create-and-start-system! []
  (println "create-and-start-system!")
  (http/start (http/create-server service-map)))

;; ================================================================================================
;; ================================================================================================

;; TODO: Adjust these to be more idiomatic

(defonce server (atom nil))
(defn test-request [verb url]
  (io.pedestal.test/response-for (::http/service-fn @server) verb url))

(defn start-dev []
  (reset! server
          (http/start (http/create-server
                       (assoc service-map
                              ::http/join? false)))))

(defn stop-dev []
  (when @server
    (http/stop @server)
    (reset! server nil)))