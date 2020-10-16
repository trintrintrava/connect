package logic.service;

import domain.Actor;
import domain.dto.ActorFullInfoDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplexService extends DataBaseService{

        public List<ActorFullInfoDto> getAllInfoForActor(String actorName) {

            List<ActorFullInfoDto> dtoList = new ArrayList<ActorFullInfoDto>();

            String sql = "select el_j.actor.name, el_j.actor.second_name, el_j.film.name as name2, el_j.film.director " +
                    "from el_j.actor " +
                    "join el_j.act_to_film on (el_j.act_to_film.id_actor = el_j.actor.id) " +
                    "join el_j.film on (el_j.act_to_film.id_film = el_j.film.id) " +
                    "where el_j.actor.name = '" + actorName+"'";
            ResultSet result = executeSql(sql);
            try {
                while (result.next()) {
//                    long id = result.getLong("id");
                    String aname = result.getString("name");
                    String secondName = result.getString("second_name");
                    String fname = result.getString("name2");
                    String director = result.getString("director");

                    ActorFullInfoDto dto = new ActorFullInfoDto();
                    dto.setName(aname);
                    dto.setSecondName(secondName);
                    dto.setName2(fname);
                    dto.setDirector(director);

                    dtoList.add(dto);

                }
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }

            return dtoList;
        }
    }
