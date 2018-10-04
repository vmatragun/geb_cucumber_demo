package stepdefs

import geb.Browser
import geb.binding.BindingUpdater
import org.slf4j.LoggerFactory

import static cucumber.api.groovy.Hooks.Before
import static cucumber.api.groovy.Hooks.After

def bindingUpdater

def LOG = LoggerFactory.getLogger("debug")

Before() { scenario ->
  bindingUpdater = new BindingUpdater(binding, new Browser())
  bindingUpdater.initialize()
  LOG.debug("Init is completed")
}

After() { scenario ->
  bindingUpdater?.remove()
}