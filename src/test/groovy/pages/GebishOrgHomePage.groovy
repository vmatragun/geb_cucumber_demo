package pages

import geb.Page

class GebishOrgHomePage extends Page {

  static at = { title == "Geb - Very Groovy Browser Automation" }

  static content = {
    manualMenuOption { $("div.menu a.manuals") }
    manualsList { $("#manuals-menu") }
    currentManualLink(to: TheBookOfGebPage) {
      manualsList.find("a", text: startsWith("current"))
    }
  }
}
