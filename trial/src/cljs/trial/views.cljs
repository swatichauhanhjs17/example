(ns trial.views
  (:require
   [re-frame.core :as re-frame]
   [trial.subs :as subs]
   ))
(defn music-component[]
( fn []

[:div 

  [:div {:class "wrap"}
 [:header
  [:div {:class "container_12"}
   [:a {:class "grid_5 cde", :href "#"} "My Music Cloud"]
   [:nav {:class "grid_7"}
    [:ul {:class "meta"}
     [:div {:class "cde"}
      [:li 
       [:a {:href "http://localhost:3456/p/htmlfiles/features.html", :target "_blank"} "Features"]]
      [:li 
       [:a {:href "http://localhost:3456/p/howitworks.html", :target "_blank"} "How it Works"]]
      [:li 
       [:a {:href "#"} "Access Plans"]]
      [:li 
       [:a {:href "#"} "Contact us"]]
      [:li 
       [:a {:href "#"} "Login"]]]]]]]]

[:div {:class "hero-unit"}
[:div {:class "textset"}
 
  [:div {:class "textrea\ndy"} "MUSIC GIVES SOUL TO THE UNIVERSE," 
   [:br]"WINGS TO THE MIND, FLIGHT TO THE" 
   [:br]"IMAGINATION AND LIFE TO EVERYTHING."]]]
[:div {:class "wrap1"}
 [:div {:class "container_12"}
  [:section {:class "meta2 grid_4"}
   [:a {:class "meta1", :href "#"}
    [:h4 "Electronic Music"]
    [:img {:src "..\\images\\edm.jpg", :alt "edm", :width "300px", :height "200px"}]
    [:p "Electronic music is any music involving electronic processing,\n           such as recording and editing on tape, and whose reproduction\n           involves the use of loudspeakers."]]]
  [:section {:class "meta2 grid_4"}
   [:a {:class "meta1", :href "#"}
    [:h4 "Rock Music"]
    [:img {:src "..\\images\\rock.jpg", :alt "rock", :width "300px", :height "200px"}]
    [:p "A form of popular music which evolved from rock and roll\n          and pop music during the mid and late 1960s.It was initially characterized by  experimentation\n          and or anti-establishment lyrics."]]]
  [:section {:class "meta2 grid_4"}
   [:a {:class "meta1", :href "#"}
    [:h4 "Pop Music"]
    [:img {:src "..\\images\\pop.jpg", :alt "pop", :width "300px", :height "200px"}]
    [:p "Pop music is a genre of popular music that originated in\n        its modern form in the Western world during the 1950s and\n         1960s, deriving from rock and roll. The terms &quot;popular\n          music&quot; and &quot;pop music&quot; are often used interchangeably,\n           although the former describes all music that is popular."]]]
  [:hr]
  [:section {:class "meta2 grid_4"}
   [:a {:class "meta1", :href "#"}
    [:h4 "Dubstep Music"]
    [:img {:src "..\\images\\dubstep.jpg", :alt "dubstep", :width "300px", :height "200px"}]
    [:p "Dubstep is a genre of electronic dance music that originated\n        in South London, England. It emerged in the late 1990s as a\n         development within a lineage of related styles such as 2-step garage,\n          dub, techno, drum and bass, broken beat, jungle, and reggae."]]]
  [:section {:class "meta2 grid_4"}
   [:a {:class "meta1", :href "#"}
    [:h4 "Trance Music"]
    [:img {:src "..\\images\\\\trance.jpg", :alt "trance", :width "300px", :height "200px"}]
    [:p "Trance is a genre of electronic music that developed during the 1990s in\n       the Netherlands. It is characterized by a tempo lying between 125 and\n        150 beats per minute (BPM), repeating melodic phrases, and a\n         musical form that distinctly builds tension and elements throughout a\n         track often culminating in 1 to 2 &quot;peaks&quot; or &quot;drops."]]]
  [:section {:class "meta2 grid_4"}
   [:a {:class "meta1", :href "#"}
    [:h4 "Trap bass"]
    [:img {:src "..\\images\\maxresdefault.jpg", :alt "trap and bass", :width "300px", :height "200px"}]
    [:p "Bass Traps are acoustic energy absorbers which are\n      designed to damp low frequency sound\n      energy with the goal of attaining a\n       flatter low frequency (LF) room\n       response by reducing LF resonances in\n       rooms. They are commonly used in\n        recording studios, mastering rooms,\n         home theatres and other rooms built\n          to provide a critical listening\n          environment."]]]
  [:hr]]]

 [:div {:class "foot"}
  [:div {:class "foot1"}
   [:ul  
    [:li 
     [:a {:href "#"} "HOME"]]
    [:li 
     [:a {:href "#"} "ABOUT US"]]
    [:li 
     [:a {:href "#"} "COPYRIGHTS"]]
    [:li 
     [:a {:href "#"} "COMMENTS"]]]
   [:ul {:class "texts"}
    [:li 
     [:a {:href "#"}
      [:i {:class "fa fa-apple fa-2x", :aria-hidden "true"}]]]
    [:li 
     [:a {:href "#"}
      [:i {:class "fa fa-android fa-2x", :aria-hidden "true"}]]]
    [:li 
     [:a {:href "#"}
      [:i {:class "fa fa-windows fa-2x", :aria-hidden "true"}]]]
    [:li 
     [:a {:href "#"}
      [:i {:class "fa fa-facebook-official fa-2x", :aria-hidden "true"}]]]
    [:li 
     [:a {:href "#"}
      [:i {:class "fa fa-instagram fa-2x", :aria-hidden "true"}]]]
    [:li 
     [:a {:href "#"}
      [:i {:class "fa fa-twitter fa-2x", :aria-hidden "true"}]]]]]]]
  

))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     [ music-component]
     ]))
