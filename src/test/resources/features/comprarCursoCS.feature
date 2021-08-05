#language: pt
Funcionalidade: : Comprar Curso CS
  Cenario: Pesquisar Curso e Incluir no Carrinho
    Dado que acesso o site da Iterasys
    Quando pesquiso por "Mantis"
    E clico na lupa
    Entao vejo a lista de resultados para o curso "Mantis"
    Quando clico no Matricule-se
    Entao confirmo o nome do curso como "Mantis" e o preco de "R$49,99"

  Esquema do Cenario: Pesquisar Curso com Enter e Incluir no Carrinho EC
    Dado que acesso o site da Iterasys
    Quando pesquiso por <curso>
    E pressiono Enter
    Entao vejo a lista de resultados para o curso <curso>
    Quando clico em Matricule-se
    Entao confirmo o nome do curso como <curso> e o preco de <preco>
    Exemplos:
      | curso               |  preco      |
      | "Mantis"            | "R$ 49,99"  |
      | "Preparatório CTFL" | "R$ 169,00" |
