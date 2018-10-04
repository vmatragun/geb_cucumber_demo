import org.slf4j.LoggerFactory
import spock.lang.Specification

class LabelPrinter {
  def _(def message) {
    LoggerFactory.getLogger("Spock").info(message)
    true
  }
}

Specification.mixin LabelPrinter