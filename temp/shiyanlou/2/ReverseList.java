import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.omg.Messaging.SyncScopeHelper;

class ReverseList<T> extends ArrayList<T> {

    private static final long serialVersionUID = 1L;
    private Collection<T> c;
    public ReverseList(Collection<T> c) {
        super(c);
        this.c = c;
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            int size = c.size();
            int index = size - 1;
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    @Override
                    public boolean hasNext() {
                        if(index >= 0){
                            return true;
                        }
                        return false;
                    }

                    @Override
                    public T next() {
                        return (T)c.toArray()[index--];
                    }
                };
            }
        };
    }
}
