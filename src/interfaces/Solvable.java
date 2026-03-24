package interfaces;

public interface Solvable {

    default Boolean isSolved() {
        return true;
    }

    void solve();

}
