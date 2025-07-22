(ns boilerplate-clojure.diplomat.http-server
  (:require
    [boilerplate-clojure.config :as config]
    [clojure.set :as set]))

(defn current-version 
  [_]
  {:status 200
   :body {:version (config/version {})}})

(def common-interceptors [])

(def default-routes
  #{["/api/version"
     :get (conj common-interceptors
                ; doc.desc "..."
                ; auth/public
                ; adapt/externalise! {200 out.version/Version}
                current-version)
     :route-name :version]})

(def application-routes
  #{})

(def routes
  (set/union
   default-routes
   application-routes))