/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.controller;

import cl.ravenhill.eventual.exceptions.UnsupportedStateOperationException;
import cl.ravenhill.eventual.ui.InputManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.jetbrains.annotations.NotNull;

public class InputListener implements PropertyChangeListener {

  private final GameController context;

  public InputListener(GameController context) {
    this.context = context;
  }

  @Override
  public void propertyChange(@NotNull PropertyChangeEvent evt) {
    try {
      switch ((InputManager.InputStatus) evt.getNewValue()) {
        case WAITING_INPUT -> context.promptSelection();
        case INPUT_RECEIVED -> context.doContextAction();
        // This should never occur, but I include it for safety reasons
        default -> throw new IllegalStateException("Unexpected value: " + evt.getNewValue());
      }
    } catch (UnsupportedStateOperationException ex) {
      ex.printStackTrace();
    }
  }
}
