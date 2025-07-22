(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [deftest is use-fixtures]]
            [state-flow.api :refer [defflow flow match?]]
            [boilerplate-clojure.components :as components]
            [clojure.data.json :as json]))

(defn with-server [f]
  (components/start-dev)
  (f)
  (components/stop-dev))

(use-fixtures :once with-server)

(defflow check-home-status-flow-version
  (flow "check home status"
        (match? 200 (:status (components/test-request :get "/api/version")))
        (match? {:version "0.0.1"}
                (-> (components/test-request :get "/api/version")
                    :body
                    (json/read-str :key-fn keyword)))))

(deftest check-home-status
  (let [response (components/test-request :get "/api/version")]
    (is (= 200 (:status response)))
    (is (= {:version "0.0.1"}
           (-> response
               :body
               (json/read-str :key-fn keyword))))))

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