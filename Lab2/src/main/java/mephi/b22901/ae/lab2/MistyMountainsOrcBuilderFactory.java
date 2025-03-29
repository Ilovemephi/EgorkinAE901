
package mephi.b22901.ae.lab2;


public class MistyMountainsOrcBuilderFactory implements OrcBuilderFactory {

    @Override
    public OrcBuilder createOrcBuilder() {
        return new MistyMountainsOrcBuilder(new MistyMountainsGearFactory());
    }
    
}
