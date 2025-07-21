(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [is]]
            [state-flow.api :refer [defflow flow]]
            [io.pedestal.test :refer [response-for]]
            [io.pedestal.http :as http]
            [boilerplate-clojure.server :as server]))

(defn make-request [{:keys [path method body]}]
  (let [servlet (http/create-servlet (server/service-map))
        response (response-for servlet method path body)]
    response))

(println (make-request {:path "/"
                        :method :get
                        :body "Hello from Pedestal!"}))

(defflow home-page-responds
  (let [response (make-request {:path "/"
                                :method :get
                                :body "Hello from Pedestal!"})]
    (is (= 200 (:status response)))
    (is (= "Hello from Pedestal!" (:body response)))))

(defflow simple-math-works
  (flow "simple math test"
        (is (= 4 (+ 2 2)))))
