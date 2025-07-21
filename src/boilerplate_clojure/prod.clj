(ns boilerplate-clojure.prod
  (:require [boilerplate-clojure.server :as server]))

(defn -main [& _]
  (server/start))
