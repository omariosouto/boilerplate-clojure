(ns boilerplate-clojure.service
  (:require [io.pedestal.http :as http]))

(defn hello-world [_]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body "{\"hello\": \"world\"}"})

(def routes
  #{["/hello" :get hello-world :route-name :hello]})

(def service
  {:env :prod
   ::http/routes routes
   ::http/type :jetty
   ::http/port 8080})