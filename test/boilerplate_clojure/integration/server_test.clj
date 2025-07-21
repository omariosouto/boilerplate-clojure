(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [deftest is]]
            [state-flow.api :refer [defflow flow match?]]
            [boilerplate-clojure.server :as server]))



(deftest sum-function-test
  (is (= 3 (server/sum 1 2))))

(defflow sum-function-test-flow-version
  (flow "sum function test"
        (match? 3
                (server/sum 1 2))))


(deftest check-home-status
  (let [response (server/test-request :get "/")]
    (is (= 200 (:status response)))
    (is (= "Hello from Pedestal!" (:body response)))))