(ns boilerplate-clojure.server
  (:require [io.pedestal.http :as http]
            [boilerplate-clojure.service :as service]))

(defonce server (atom nil))

(defn start []
  (reset! server (http/start (http/create-server service/service))))

(defn stop []
  (when @server
    (http/stop @server)
    (reset! server nil)))