package pl.jnowacki.dao;

import pl.jnowacki.model.Tool;
import pl.jnowacki.model.ToolType;

import java.util.Arrays;
import java.util.List;

public class ToolDaoImpl implements ToolDao{

    @Override
        public List<Tool> getAll() {

            Tool tool1 = new Tool(1, "Sonic screwdriver", ToolType.SCREWDRIVER, true);
            Tool tool2 = new Tool(2, "Srubokret od kamaza", ToolType.SCREWDRIVER, false);
            Tool tool3 = new Tool(3, "Stara pila", ToolType.SAW, true);
            Tool tool4 = new Tool(4, "Czerwony mlotek", ToolType.HAMMER, true);

            return Arrays.asList(tool1, tool2, tool3, tool4);
    }
}
