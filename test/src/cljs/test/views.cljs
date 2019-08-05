
(ns test.views
  (:require
   [re-frame.core :as re-frame]
   [test.subs :as subs]
   [reagent.core :as r]
   ))



(defn atom-input [final]
        
         [:input {:type "text"
                    :value @value
                    :on-change #(reset! value (-> % .-target .-value))
}])

(defn age-input [final]
           [:input {:type "text"
                    :value @age
                    :on-change #(reset! age (-> % .-target .-value))}])

(defn add-input [final]
           [:input {:type "text"
                    :value @address
                    :on-change #(reset! address (-> % .-target .-value))}]         
)


(defn shared-state []
  (let [final (r/atom {:value "NAME" :age "AGE" :address "ADDRESS"})]
    (fn []
      [:div
       
       [:p "NAME: " [atom-input final]]
       [:p "AGE: " [age-input final]]
       [:p "ADDRESS: " [add-input final]]
       [:input {:type "button" :value "SUBMIT"
                  :on-click #(re-frame/dispatch [:identity @final])}]])))



(defn main-panel []

 (let [name (re-frame/subscribe [::subs/name])
       final (re-frame/subscribe[::subs/final])]
 [:div
[shared-state]
    
[:h4 "Hello from " @name]

[:h4 "NAME:-" @final]




   ]))
