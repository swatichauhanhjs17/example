(ns test.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::address
 (fn [db]
   (:address db)))

(re-frame/reg-sub
 ::age
 (fn [db]
   (:age db)))

(re-frame/reg-sub
 ::value
 (fn [db]
   (:value db)))
