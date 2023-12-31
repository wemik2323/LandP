domains
    gorod, strana = symbol
predicates
    situ(gorod, strana)
clauses
    situ("london",england).
    situ(london, england).
    situ(petersburg, russia).
    situ(kiev, ukraine).
    situ(warszawa, poland).
    situ(berlin, europe).
    situ(X, europe) :- situ(X, russia).
    situ(X, europe) :- situ(X, poland).
    
    %ADDED
    situ(kiev, X) :- situ(moscow, X).
    situ(X, europe) :- situ(X, latvia).
    situ(X, asia) :- situ(X, china).
    situ(X, america) :- situ(X, usa).
    situ(X, america) :- situ(X, mexico).
    situ(X, asia) :- situ(X, mongolia).
    situ(X, eurasia) :- situ(X, asia).
    situ(X, eurasia) :- situ(X, europe).
    
    situ(moscow, russia).
    situ(riga, latvia).
    situ(los_angeles, usa).
    situ(washington, usa).
    situ(mexico_city, mexico).
    situ(beijin, china).
    situ(new_delhi, india).
    situ(ulaanbaatar, mongolia).
    
    situ(tallin, estonia).
    situ(X, europe) :- situ(X, estonia).
    situ(syndey, australia).
    situ(X, australia_kontinent) :- situ(X, australia).