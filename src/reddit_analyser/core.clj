(ns reddit-analyser.core
  (:require [clj-http.client :as client] 
            [cheshire.core :refer [parse-string]])  
  (:gen-class))

(def options {:headers {"User-agent" "bond-007"}
              :query-params {:limit 100}})

(def url "https://www.reddit.com/r/Clojure.json")

(parse-string (:body (client/get url options)))


