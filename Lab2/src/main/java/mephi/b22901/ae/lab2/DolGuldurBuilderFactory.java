
package mephi.b22901.ae.lab2;


public class DolGuldurBuilderFactory implements OrcBuilderFactory {

    @Override
    public OrcBuilder createOrcBuilder() {
        return new DolGuldurOrcBuilder(new DolGuldurGearFactory());
    }
    
}
