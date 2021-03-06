(ns bia_utils.test.util
  (:use [bia_utils.util])
  (:use [clojure.test]))

(deftest is-data-available-test
  (is (= true  (is-data-available 0 2 2)))
  (is (= false (is-data-available 1 2 2)))
  (is (= true  (is-data-available 1 3 2)))
  (is (= true  (is-data-available 2 3 1)))
  (is (= false (is-data-available 2 2 1)))
  (is (= false (is-data-available 1 1 1)))
  )

(deftest add-one-k-mer-test
  (is (= {"qwe" 1} (add-one-k-mer 0 "qwer" 3 {})))
  (is (= {"qwe" 2 "asd" 3} (add-one-k-mer 0 "qwer" 3 {"qwe" 1 "asd" 3})))
  (is (= {"wer" 1 "asd" 3} (add-one-k-mer 1 "qwer" 3 {"asd" 3})))
  )

(deftest add-provided-k-mer-test
  (is (= {"qwe" 1} (add-provided-k-mer "qwe" {})))
  (is (= {"qwe" 2 "asd" 3} (add-provided-k-mer "qwe" {"qwe" 1 "asd" 3})))
  (is (= {"wer" 1 "asd" 3} (add-provided-k-mer "wer" {"asd" 3})))
  )

(deftest get-one-k-mer-test
  (is (= "qwe" (get-one-k-mer 0 "qwer" 3)))
  (is (= "wer" (get-one-k-mer 1 "qwer" 3)))
  )

(deftest find-max-value-test
  (is (= 3 (find-max-value [["qwe" 1] ["asd" 3]])))
  (is (= 3 (find-max-value [["qwe" 3] ["asd" 3]])))
  )

(deftest find-max-items-test
  (is (= [["asd" 3]] (find-max-items [["qwe" 1] ["asd" 3]])))
  (is (= [["asd" 3] ["qwe" 3]]
         (sort (find-max-items [["qwe" 3] ["asd" 3]]))))
  )

