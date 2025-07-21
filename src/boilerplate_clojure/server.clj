(ns boilerplate-clojure.server
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

(defn home-page [_]
  {:status 200
   :body "Hello from Pedestal!"})

(def routes
  (route/expand-routes
   #{["/" :get home-page :route-name :home]}))

(defn service-map []
  (-> {::http/routes routes
       ::http/type   :jetty
       ::http/port   8080
       ::http/join?  false}
      http/default-interceptors))

(defn service []
  (http/create-servlet (service-map)))

(defn start []
  (http/start (http/create-server (service))))

(defn stop [server]
  (http/stop server))

(defn -main [& _]
  (start)
  (println "Server started on port 8080"))