(ns org-cms.nav)

(defn open-nav []
  (aset (.-style (.getElementById js/document "side-nav")) "width" "480px"))

(defn close-nav []
  (aset (.-style (.getElementById js/document "side-nav")) "width" "0"))
