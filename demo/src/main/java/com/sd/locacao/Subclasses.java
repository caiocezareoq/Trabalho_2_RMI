package com.sd.locacao;

class Gerador extends Aparelho {
    private static final long serialVersionUID = 2L;

    // Construtor padrão (sem argumentos)
    public Gerador() {
    }

    public Gerador(String nome, double precoLocacao) {
        super(nome, precoLocacao);
    }
}

class Mesas extends Aparelho {
    private static final long serialVersionUID = 4L;
    
    // Construtor padrão (sem argumentos)
    public Mesas() {
    }
    public Mesas(String nome, double precoLocacao) {
        super(nome, precoLocacao);
    }
}

class Palco extends Aparelho {
    private static final long serialVersionUID = 3L;

    // Construtor padrão (sem argumentos)
    public Palco() {
    }
    public Palco(String nome, double precoLocacao) {
        super(nome, precoLocacao);
    }
}

class Talheres extends Aparelho {
    private static final long serialVersionUID = 5L;

    // Construtor padrão (sem argumentos)
    public Talheres() {
    }
    public Talheres(String nome, double precoLocacao) {
        super(nome, precoLocacao);
    }
}
