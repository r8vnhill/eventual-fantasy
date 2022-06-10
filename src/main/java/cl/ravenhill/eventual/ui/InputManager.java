/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.ui;

import java.beans.PropertyChangeSupport;
import java.util.Observable;
import java.util.Observer;

public class InputManager extends Observable {
  PropertyChangeSupport pcs = new PropertyChangeSupport(this);

  public void addObserver(Observer observer) {
    addObserver(observer);
  }

  public void promptForInput() {
    setChanged();
    notifyObservers(false);
  }

  public void processInput() {
    setChanged();
    notifyObservers(true);
  }
}
