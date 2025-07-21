(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [deftest is]]
            [boilerplate-clojure.server :as server]))



(deftest sum-function-test
  (is (= 3 (server/sum 1 2))))
