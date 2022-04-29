/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Lucas
 */
public class TeskController {
    
    public void save(Task task){
        String sql = "INSERT INTO TESKS (idProject"
                + "name,"
                + "drescription,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            //Estabelecendo a conexão com o banco de dados 
            connection = ConnectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao salva a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Task task){
        
        String sql = "UPDATE TASKS SET "
                + "idProject = ?,"
                + "name = ?,"
                + "description = ?,"
                + "notes = ?,"
                + "completed = ?,"
                + "deadline = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?"
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados 
            connection = ConnectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            //Executando a query
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar tarefa" + ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void removeById(int taskid) throws SQLException{
        
        String sql = "DELETE FROM TASKS WHERE ID = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados 
            connection = ConnectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores do statement
            statement.setInt(1, taskid);
            //Executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex);        
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public List<Task> getAll(int idProject){
        
        String sql = "SELECT * FROM TASKS WHERE idProject = ?";
        
       Connection connection = null;
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       
       //Lista de tarefas será devolvida quando a chamada do método acontecer
       List<Task> tasks = new ArrayList<Task>();
       
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores do statement
            statement.setInt(1, idProject);
            //Valor retornado pela a execusão da query
            resultSet = statement.executeQuery();
            
            //Enquanto ouver valores a seram percoridos no meu resultSet
            while(resultSet.next()){
                
               Task task = new Task();
               task.setId(resultSet.getInt("id"));
               task.setIdProject(resultSet.getInt("idProject"));
               task.setName(resultSet.getString("name"));
               task.setDescription(resultSet.getString("description"));
               task.setNotes(resultSet.getString("notes"));
               task.setIsCompleted(resultSet.getBoolean("isCompleted"));
               task.setDeadline(resultSet.getDate("deadline"));
               task.setCreatedAt(resultSet.getDate("createdAt"));
               task.setUpdatedAt(resultSet.getDate("updadedAt"));
               tasks.add(task);    
            }
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir a tarefa"); 
        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
       
        //Lista de tarefas que foi criadae carregada do banco de dados
        return tasks;
        
    }
}
