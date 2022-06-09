/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual;

import cl.ravenhill.eventual.controller.InputHandler;
import java.beans.PropertyChangeSupport;

public class InputManager {
  private final PropertyChangeSupport inputPromptNotification = new PropertyChangeSupport(this);

  public void addInputPromptListener(InputHandler listener) {
    inputPromptNotification.addPropertyChangeListener(listener);
  }

  public void promptForInput() {
    inputPromptNotification.firePropertyChange("promptForInput", null, false);
  }

  public void processInput() {
    inputPromptNotification.firePropertyChange("processInput", null, true);
  }
}
