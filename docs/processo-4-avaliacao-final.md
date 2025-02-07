### 3.3.4 Processo 4 – Avaliação Final

Processo destinado à avaliação final de todo progresso do paciente, detalhando as dificuldades enfrentadas pelo paciente, e sua evolução clinica.

#### Características:

* Avaliação pós ficha de exercícios: Após o paciente ter concluído a ficha de exercícios prescrita, o profissional realiza uma avaliação detalhada do progresso do paciente. Isso pode envolver a análise de diversos fatores, como a aderência do paciente ao programa, a melhoria nas capacidades físicas e funcionais, a redução de sintomas ou desconfortos, e qualquer outra mudança relevante observada durante o período em que a ficha foi seguida.
* Feedback ao paciente: Com base na avaliação realizada, o profissional fornece um feedback detalhado ao paciente. Isso pode incluir reconhecimento dos progressos alcançados, identificação de áreas em que houve melhora significativa e reconhecimento do esforço e dedicação do paciente ao seguir o programa de exercícios.
* Decisão sobre o próximo passo: Após avaliar o progresso do paciente, o profissional toma uma decisão sobre o próximo passo a ser seguido. Isso pode variar de acordo com as necessidades individuais do paciente e os objetivos do tratamento. Algumas possibilidades incluem: Continuidade do programa atual, revisão da ficha de exercícios, e o encerramento do tratamento.

**Oportunidades de Melhoria:**
- Implementar um sistema de avaliação mais detalhado para mensurar o progresso do paciente.
- Padronizar critérios para determinar se outra ficha de exercícios é necessária ou se o paciente demonstrou melhoras significativas.

**Modelo do Processo 4 (BPMN):**

![Modelo BPMN do Processo 4](images/processo-4-processo-de-feedback(2).png "Modelo BPMN do processo 4.")

#### Detalhamento das Atividades

**Atividade 1: Analisa a ficha do paciente**

| **Campo**                    | **Tipo**          | **Restrições**          | **Valor default**  |
| ---------------------------- | ----------------- | ----------------------- | ------------------ |
| CPF do paciente              | Área de texto     | Obrigatório para visualização |              |
| Descrição                    | Área de texto     | Não editável            |                    |
| Nome exercício               | Área de texto     | Não editável            |                    |
| Avaliação                    | Icone             | Não editável            |                    |


| **Comandos**               | **Destino**                                                | **Tipo**  |
| -------------------------- | ---------------------------------------------------------- | --------- |
| Sair                       | Página inicial da aplicação                                | Default   |
| Pesquisar                  | Exibe a ficha do paciente                                  | Default   |

---
**Atividade 2: Resgistra avaliação do paciente**

| **Campo**          | **Tipo**          | **Restrições**        | **Valor default**  |
| ------------------ | ----------------- | --------------------- | ------------------ |
| Nome do paciente   | Área de Texto     | Obrigatório           |                    |
| CPF do paciente    | Área de Texto     | Obrigatório           |                    |
| Data do término    | Data              | Obrigatório           |                    |
| Título             | Área de Texto     | Obrigatório           |                    |
| Avaliação          | Área de Texto     | Obrigatório           |                    |

| **Comandos**          | **Destino**                  | **Tipo**   |
| --------------------- | ---------------------------- | ---------- |
| Salvar                | Salva avaliação no sistema   | Default    |
| Sair                  | Voltar para Home do paciente | Default    |

---
**Atividade 3: Visualiza avaliação do profissional**

| **Campo**          | **Tipo**          | **Restrições**        | **Valor default**  |
| ------------------ | ----------------- | --------------------- | ------------------ |
| Nome do paciente   | Texto             | Não editável          |                    |
| Phone              | Texto             | Não editável          |                    |
| Email              | Texto             | Não editável          |                    |
| Título             | Texto             | Não editável          |                    |
| Descrição da avaliação | Texto         | Não editável          |                    |

| **Comandos**          | **Destino**                  | **Tipo**   |
| --------------------- | ---------------------------- | ---------- |
| Imprimir              | Imprimir página              | Default    |
