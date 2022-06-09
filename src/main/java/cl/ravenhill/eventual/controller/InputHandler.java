/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InputHandler implements PropertyChangeListener {
  private final Controller controller;

  public InputHandler(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getNewValue() instanceof Boolean) {
      boolean flag = (boolean) evt.getNewValue();
      if (flag) {
        controller.runContextAction();
      } else {
        controller.promptCharacterSelection();
      }
    }
  }
}
