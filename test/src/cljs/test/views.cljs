(ns test.views
  (:require
   [re-frame.core :as re-frame]
   [test.subs :as subs]
   [reagent.core :as r]
   ))



(defn atom-input [value]
        
         [:input {:type "text"
                    :value @value
                    :on-change #(reset! value (-> % .-target .-value))
}])

(defn age-input [age]
           [:input {:type "text"
                    :value @age
                    :on-change #(reset! age (-> % .-target .-value))}])

(defn add-input [add]
           [:input {:type "text"
                    :value @add
                    :on-change #(reset! add(-> % .-target .-value))}]         
)


(defn shared-state []
  (let [value (r/atom "NAME")
        age (r/atom " AGE")
        add (r/atom "ADD")]
    (fn []
      [:div
       
       [:p "NAME: " [atom-input value]]
       [:p "AGE: " [age-input age]]
       [:p "ADDRESS: " [add-input add]]
       [:input {:type "button" :value "SUBMIT"
                  :on-click #(re-frame/dispatch [:identity]) }]])))



(defn main-panel []

 (let [  name (re-frame/subscribe [::subs/name])
         val(re-frame/subscribe [::subs/value])]
 [:div
[shared-state]
    [:h4 "Hello from " @name]

[:h4 "Hello" @val]

   ]))
