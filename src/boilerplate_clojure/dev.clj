(ns boilerplate-clojure.dev
  (:require [boilerplate-clojure.server :as server]))

(defn start []
  (server/start))

(defn stop []
  (server/stop))
