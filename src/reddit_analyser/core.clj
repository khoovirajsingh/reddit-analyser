(ns reddit-analyser.core
  (:require [clj-http.client :as client])
  (:gen-class))

(def options {:headers {"User-agent" "bond-007"}
              :query-params {:limit 100}})

(def url "https://www.reddit.com/r/Clojure.json")

(client/get url options)
