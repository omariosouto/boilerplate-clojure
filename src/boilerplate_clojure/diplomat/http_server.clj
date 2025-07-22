(ns boilerplate-clojure.diplomat.http-server
  (:require
    [boilerplate-clojure.config :as config]))

(def version-interceptor
  {:name :version
   :enter
   (fn [context]
     (let [response {:status 200 :body {:version (config/version {})}}]
       (assoc context :response response)))})

(def routes
  #{["/api/version" :get version-interceptor :route-name :version]})