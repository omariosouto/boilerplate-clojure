(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [deftest is]]
            [state-flow.api :refer [defflow flow match?]]
            [boilerplate-clojure.components :as components]))

(components/start-dev)

(defflow check-home-status-flow-version
  (flow "check home status"
        (match? 200 (:status (components/test-request :get "/")))
        (match? {:version "0.0.1"} (:body (components/test-request :get "/api/version")))))

(deftest check-home-status
  (let [response (components/test-request :get "/api/version")]
    (is (= 200 (:status response)))
    (is (= {:version "0.0.1"} (:body response)))))

;; ================================================================================================
;; ================================================================================================
;; ================================================================================================
;; ================================================================================================
;; ================================================================================================


(defn sum [a b]
  (+ a b))

(deftest sum-function-test
  (is (= 3 (sum 1 2))))

(defflow sum-function-test-flow-version
  (flow "sum function test"
        (match? 3
                (sum 1 2))))