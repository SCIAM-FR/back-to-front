import { Component, OnInit } from '@angular/core';
import { BoardGame, BoardGameService } from '../boardgame.service';

@Component({
  selector: 'app-board-game-list',
  templateUrl: './boardgame-list.component.html',
  //styleUrls: ['./boardgame-list.component.css'],
})
export class BoardGameListComponent implements OnInit {
  boardGames: BoardGame[] = [];

  constructor(private boardGameService: BoardGameService) {}

  ngOnInit(): void {
    this.loadBoardGames();
  }

  private loadBoardGames(): void {
    this.boardGameService.getBoardGames().subscribe(
      (data) => {
        this.boardGames = data;
      },
      (error) => {
        console.error('Error fetching board games:', error);
      }
    );
  }
}
