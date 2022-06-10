/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.controller;

import cl.ravenhill.eventual.exceptions.UnsupportedStateOperationException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InputListener implements PropertyChangeListener {

  private final GameController context;

  public InputListener(GameController context) {
    this.context = context;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    try {
      if ((Boolean) evt.getNewValue()) {
        context.doAttack();
      } else {
        context.promptSelection();
      }
    } catch (UnsupportedStateOperationException ex) {
      ex.printStackTrace();
    }
  }
}
