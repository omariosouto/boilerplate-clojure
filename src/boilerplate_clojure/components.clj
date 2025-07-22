(ns boilerplate-clojure.components
  (:require [boilerplate-clojure.diplomat.http-server :as diplomat.http-server]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.test :as test]))

;; (defn local [initial-state]
;;   (println "local"))
;; (defn test [initial-state]
;;   (println "test"))


(def routes
  (diplomat.http-server/routes))

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