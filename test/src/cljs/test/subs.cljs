(ns test.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::add
 (fn [db]
   (:add db)))

(re-frame/reg-sub
 ::value
 (fn [db]
   (:value db)))
