package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.service.GoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Tag(name = "Goal / Meta", description = "Gestion de metas donde la persona desea enfocar su entrenamiento")
@RequestMapping("/goal")
public class GoalController
{
    @Autowired
    GoalService goalService;


    @PostMapping
    @Operation(summary = "Registra una nueva meta en la base de datos")
    public ResponseEntity<Goal> add(@RequestBody @Valid Goal goal) throws Exception{
        return ResponseEntity.ok( goalService.saveGoal( goal ));
    }

    @GetMapping
    @Operation(summary = "Retorna la lista de metas almacenadas")
    public List<Goal> list()
    {
        return goalService.listAllGoal();
    }

    @Operation(summary = "Retorna una meta especifica basada en el id")
    /*
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Return a simple goal record",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = ZEStrings.CODE_404,
                    description = ZEStrings.MESSAGE_404,
                    content = @Content)
    })*/
    @GetMapping( "/{id}" )
    public ResponseEntity<Goal> get( @PathVariable Integer id)  {
        try {
            Goal goal = goalService.getGoal( id );
            return new ResponseEntity<Goal>( goal, HttpStatus.OK );
        }
        catch ( NoSuchElementException e )  {
            return new ResponseEntity<Goal>( HttpStatus.NOT_FOUND );
        }
    }



    @PutMapping("/{id}")
    @Operation(summary = "Edita una meta basada en el id")
    public ResponseEntity<?> update(@RequestBody Goal goal, @PathVariable Integer id) {
        try {
            Goal existGoal = goalService.getGoal( id );
            if ( existGoal != null ) //  en el caso de que si exista
            {
                existGoal.setName( goal.getName() );
                existGoal.setDescription( goal.getDescription() );
                goalService.saveGoal( existGoal );
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else {
                return new ResponseEntity<Goal>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una meta de la base de datos tomando como referencia el id")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Goal existGoal = goalService.getGoal( id );
            if ( existGoal != null ) {
                goalService.deleteGoal( id );
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else  {
                return new ResponseEntity<Goal>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
