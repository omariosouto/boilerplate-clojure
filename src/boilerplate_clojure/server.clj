(ns boilerplate-clojure.server)

(defn sum [a b]
  (+ a b))

(defn -main [& _args]
  (println (sum 1 2)))