-- Insert some games
INSERT INTO BoardGameEntity (id, name, releaseYear, categories) VALUES
    (1, 'Gloomhaven', 2017, JSON_ARRAY('COOPERATIVE', 'DUNGEON_CRAWLER')),
    (2, 'Terraforming Mars', 2016, JSON_ARRAY('STRATEGY')),
    (3, 'Pandemic', 2008, JSON_ARRAY('COOPERATIVE', 'STRATEGY')),
    (4, 'Catan', 1995, JSON_ARRAY('STRATEGY', 'RESOURCE_MANAGEMENT')),
    (5, 'Ticket to Ride', 2004, JSON_ARRAY('FAMILY', 'STRATEGY')),
    (6, 'Carcassonne', 2000, JSON_ARRAY('TILE_PLACEMENT', 'STRATEGY')),
    (7, 'Scythe', 2016, JSON_ARRAY('STRATEGY', 'AREA_CONTROL')),
    (8, 'Azul', 2017, JSON_ARRAY('ABSTRACT', 'TILE_PLACEMENT')),
    (9, 'Codenames', 2015, JSON_ARRAY('PARTY', 'WORD_GAME')),
    (10, '7 Wonders', 2010, JSON_ARRAY('CARD_DRAFTING', 'STRATEGY'))
;