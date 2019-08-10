package pl.jnowacki.dao;

import pl.jnowacki.model.Tool;
import pl.jnowacki.model.ToolType;
import pl.jnowacki.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolDaoImpl implements ToolDao{

    private List<Tool> tools;

    public ToolDaoImpl() {
        Tool tool1 = new Tool(1, "Sonic screwdriver", ToolType.SCREWDRIVER, true);
        Tool tool2 = new Tool(2, "Srubokret od kamaza", ToolType.SCREWDRIVER, false);
        Tool tool3 = new Tool(3, "Stara pila", ToolType.SAW, true);
        Tool tool4 = new Tool(4, "Czerwony mlotek", ToolType.HAMMER, true);

        tools = Arrays.asList(tool1, tool2, tool3, tool4);
    }

    @Override
    public List<Tool> getAll() {

        List<Tool> tools = new ArrayList<>();

        String selectSQL = "SELECT * FROM tools";

        try (Connection dbConnection = DbConnection.getInstance().getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                long toolId = rs.getLong("id");
                String toolName = rs.getString("name");
                ToolType toolType = ToolType.valueOf(rs.getString("type"));
                boolean toolAvailability = rs.getBoolean("available");

                tools.add(new Tool(toolId, toolName, toolType, toolAvailability));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tools;
    }

    @Override
    public void setAvailability(boolean isAvailable, long id) {

        String selectSQL = "UPDATE tools SET available = ? WHERE id = ?";

        try (Connection dbConnection = DbConnection.getInstance().getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setBoolean(1, isAvailable);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
