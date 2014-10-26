(ns bia_utils.util
  ;; (:use clojure.tools.trace)
  )

;;(trace-ns 'bia_utils.util)

(defn is-data-available [i len k]
  (let [end (+ i k)]
    (<= end len)))

(defn get-one-k-mer [i text k]
  (let [end (+ i k)
        k-mer (subs text i end)]
    k-mer))

(defn add-one-k-mer [i text k acc]
  (let [k-mer (get-one-k-mer i text k)
        new-acc (update-in acc [k-mer] (fnil inc 0))]
    new-acc))

