(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [deftest is]]
            [state-flow.api :refer [defflow flow match?]]
            [boilerplate-clojure.server :as server]))

(server/start-dev)

(deftest sum-function-test
  (is (= 3 (server/sum 1 2))))

(defflow sum-function-test-flow-version
  (flow "sum function test"
        (match? 3
                (server/sum 1 2))))

(defflow check-home-status-flow-version
  (flow "check home status"
        (match? 200 (:status (server/test-request :get "/")))
        (match? "Hello from Pedestal!" (:body (server/test-request :get "/")))))

(deftest check-home-status
  (let [response (server/test-request :get "/")]
    (is (= 200 (:status response)))
    (is (= "Hello from Pedestal!" (:body response)))))

(server/stop-dev)