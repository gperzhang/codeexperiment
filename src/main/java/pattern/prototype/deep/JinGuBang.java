package pattern.prototype.deep;

import java.io.Serializable;

public class JinGuBang implements Serializable {
    private float h = 100;
    private float d = 10;

    private void big(){
        this.h = h*2;
        this.d = d*2;
    }
    private void small(){
        this.h = h/2;
        this.d = d/2;
    }
}
