/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.ui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InputManager {
  PropertyChangeSupport inputPromptNotification = new PropertyChangeSupport(this);

  public void addInputPromptListener(PropertyChangeListener listener) {
    inputPromptNotification.addPropertyChangeListener(listener);
  }

  public void promptForInput() {
    inputPromptNotification.firePropertyChange("Input Prompt", null, InputStatus.WAITING_INPUT);
  }

  public void processInput() {
    inputPromptNotification.firePropertyChange("Input Received", null, InputStatus.INPUT_RECEIVED);
  }

  public enum InputStatus {
    WAITING_INPUT,
    INPUT_RECEIVED
  }
}
