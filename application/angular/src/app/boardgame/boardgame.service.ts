import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface BoardGame {
  id: number;
  name: string;
  releaseYear: number;
  categories: string[];
  // Add other properties as needed
}

@Injectable({
  providedIn: 'root',
})
export class BoardGameService {
  private apiUrl = 'http://localhost:8080/boardgame';

  constructor(private http: HttpClient) {}

  getBoardGames(): Observable<BoardGame[]> {
    return this.http.get<BoardGame[]>(this.apiUrl);
  }
}
