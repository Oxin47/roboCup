package code
package comet

import net.liftweb.http._
import ru.ya.vn91.robotour.Constants._
import scala.xml.{Text, NodeSeq}

class TimeStart extends CometActor with CometListener {
	private var time = 0L

	def registerWith = TimeStartSingleton

	override def lowPriority = {
		case newTime: Long => time = newTime; reRender()
	}

	def render = Text(
		if (time > 0) timeLongToString(time - registrationTime.toMillis)
		else "undefined yet")
}
